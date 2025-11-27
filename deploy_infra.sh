#!/bin/bash

# 1. Install Terraform
# 2. Run Terraform Apply
cd infra
terraform init
terraform apply -auto-approve

# 3. Get Outputs
EC2_IP=$(terraform output -raw ec2_public_ip)
RDS_ENDPOINT=$(terraform output -raw rds_endpoint)

echo "Infrastructure Provisioned!"
echo "EC2 IP: $EC2_IP"
echo "RDS Endpoint: $RDS_ENDPOINT"

# 4. SSH and Deploy (Example)
# ssh -i my-key.pem ubuntu@$EC2_IP "git clone https://github.com/your-repo/rewards.git && cd rewards && docker-compose up -d"
