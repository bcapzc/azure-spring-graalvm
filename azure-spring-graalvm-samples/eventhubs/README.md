# GraalVM Native Image Sample of Azure Key Vault Secrets Spring Boot Starter client library 

# Key Concepts

This code sample demonstrates how to use Spring Integration for Azure Event Hub as a standard Spring application and as a GraalVM Native Image.

# Getting Started

Running this sample will be charged by Azure. You can check the usage and bill at this [link](https://azure.microsoft.com/account/).

## Dependencies

To run this sample, two dependencies are required to be installed. They are [Azure GraalVM Support]() and [Azure Spring GraalVM Support](), where Azure GraalVM Support provides configuration for Azure SDKs and Azure Spring GraalVM Support provides some additional configurations for Azure Spring Boot Libraries.

## Create Azure resources

1. Create [Azure Event Hubs](https://docs.microsoft.com/azure/event-hubs/). Please note `Basic` tier is unsupported. After creating the Azure Event Hub, you can create your own Consumer Group or use the default "$Default" Consumer Group.

2. Create [Azure Storage](https://docs.microsoft.com/azure/storage/) for checkpoint use.

3. [Optional] if you want to use service principal, please follow [create service principal from Azure CLI](https://github.com/Azure-Samples/azure-spring-boot-samples/blob/main/create-sp-using-azure-cli.md) to create one.

4. [Optional] if you want to use managed identity, please follow [create managed identity](https://github.com/Azure-Samples/azure-spring-boot-samples/blob/main/create-managed-identity.md) to set up managed identity.

## Configure the application.properties

1. Update `application.yaml`. If you choose to use service principal or managed identity, update the application-sp.yaml or application-mi.yaml respectively.

```
spring:
  cloud:
    azure:
      eventhub:
        connection-string: [eventhub-namespace-connection-string]
        checkpoint-storage-account: [checkpoint-storage-account]
        checkpoint-access-key: [checkpoint-access-key]
        checkpoint-container: [checkpoint-container]
```

2. Update event hub name and consumer group in ReceiveController and SendController.

## How to run

### 1. To run this sample as a standard Spring application

Use the following command:

```
mvn spring-boot:run
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

Send a POST request.

```
$ curl -X POST http://localhost:8080/messages?message=hello
```

Verify in your app’s logs that a similar message was posted:

```
New message received: 'hello'
Message 'hello' successfully checkpointed
```

Delete the resources on [Azure Portal](https://ms.portal.azure.com/) to avoid unexpected charges.