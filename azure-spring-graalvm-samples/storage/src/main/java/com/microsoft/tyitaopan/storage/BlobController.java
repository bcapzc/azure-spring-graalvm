package com.microsoft.tyitaopan.storage;

import com.azure.spring.autoconfigure.storage.resource.AzureStorageResourcePatternResolver;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@RestController
public class BlobController {

    @Autowired
    private BlobServiceClientBuilder blobServiceClientBuilder;

    @Value("${resource.blob}")
    // @Value("azure-blob://container1/testBlob.txt")
    private Resource testFileBlob;

    @GetMapping("/listall")
    public String listAll() {
        String searchPattern = "azure-blob://*/*";
        try {
            String fileNames = "";
            Resource[] resources = new AzureStorageResourcePatternResolver(blobServiceClientBuilder.buildClient())
                    .getResources(searchPattern);
            for (Resource resource: resources) {
                String fileName = resource.getFilename();
                System.out.println(fileName);
                fileNames = fileNames + fileName + "\n";
            }
            return fileNames;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/readblob")
    public String readBlob() {
        try {
            String fileContent = StreamUtils.copyToString(testFileBlob.getInputStream(), Charset.defaultCharset());
            System.out.println(fileContent);
            return fileContent;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @PostMapping("/updateblob")
    public String updateBlob(@RequestParam("newcontent") String newFileContent) {
        try (OutputStream os = ((WritableResource) this.testFileBlob).getOutputStream()) {
            os.write(newFileContent.getBytes());

            String msg = "testBlob.txt is updated";
            System.out.println(msg);
            return msg;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
