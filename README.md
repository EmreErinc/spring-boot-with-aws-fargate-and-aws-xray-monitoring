AWS X-Ray Configuration to Fargate

 - First of all we need upload application images  to ECR(Elastic Container Repository) for task definition. 
 PS: If we have CI/CD for custom our application just we need to upload x-ray image to ECR.
 
 - After upload app images we need to define 'Task Definition'. For an easy way, copy json in the `taskdefinition.json` paste to 'Configure via JSON' and create task definition.
 
 - Then we need to create cluster and service. In this step we should define role to service for run task. We should create custom role on the IAM Console, under the 'Roles' segment. 
 
 - After define a custom role name, we need to attach two policy. These are 'AmazonECSTaskExecutionRolePolicy' and 'AWSXRayDaemonWriteAccess'.
 
 - After role creation process, continue to service creation step with that role. `taskdefinition.json` file will make basic configurations. If we want, we can change it also. 
 
 - After service creation step, that role generate Fargate tasks and app metrics can stream to AWS X-Ray Dashboard. 

---

Sources:
 - https://docs.aws.amazon.com/xray/latest/devguide/xray-sdk-java.html
 - https://docs.aws.amazon.com/xray/latest/devguide/xray-daemon-ecs.html
 - https://github.com/aws-samples/aws-xray-fargate
 
---

TODO:
 - Add step by step guide