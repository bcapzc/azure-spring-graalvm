# GraalVM Native Image Support Sample of Azure Spring Boot Storage Starter Library for Java

# Key Concepts

This code sample demonstrates a sample of how to read and write an Azure blob with Spring Resource abstraction for Azure Storage using the [Azure Spring Boot Starter Storage](https://github.com/Azure/azure-sdk-for-java/blob/azure-spring-boot_3.6.0/sdk/spring/azure-spring-boot-starter-storage). 

# Getting Started

Running this sample will be charged by Azure. You can check the usage and bill at this [link](https://azure.microsoft.com/account/).

## Dependencies

To run this sample, two dependencies are required to be installed. They are [Azure GraalVM Support]() and [Azure Spring GraalVM Support](), where Azure GraalVM Support provides configuration for Azure SDKs and Azure Spring GraalVM Support provides some additional configurations for Azure Spring Boot Libraries.

## Configure the application.properties

1. Create [Azure Storage](https://docs.microsoft.com/zh-cn/azure/storage/)

2. Create a container.

3. Upload some Blob resource you like into the container.

4. Update application.properties with information on Azure Protal.

```
azure.storage.accountName=[Storage account name]
azure.storage.accountKey=[Storage account access key]
azure.storage.blobEndpoint=[Storage blob service endpoint URL]

resource.blob=[azure-blob://[your-container-name]/[your-blob-name]]
```

## How to run

### 1. To run this sample as a standard Spring application

Use the following command:

```
mvn clean package exec:java
```

### 2. To compile and run this sample as a native image

Use this command to compile:

```
mvn clean package -Pnative -DskipTests
```

Once the image compilation is completed, you can find the native executable under `target` folder, which can be executed using the following command:

```
./target/storage
```

## How to use

Send the following GET request to obtain a list of your Blob resources:

```
curl -XGET http://localhost:8080/listall 
```

Send the following GET request to read the content of the Blob resource:

```
curl -XGET http://localhost:8080/readblob
```

Send the following POST request to update the content of the Blob resource:

```
curl -XPOST http://localhost:8080/updateblob\?newcontent\=test%20content  
```