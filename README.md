# 


## 모델링

![모델링](https://user-images.githubusercontent.com/85432029/226529207-6dbfffe4-e885-492a-abf3-8b9db64d6e09.png)

## SAGA+Compensation/Correlation

# 주문

![01_주문](https://user-images.githubusercontent.com/85432029/226529232-59476872-cdc8-42b3-9ede-49834c06dac5.PNG)

# 주문 취소

![02_주문취소](https://user-images.githubusercontent.com/85432029/226529245-79a71502-a09a-4298-b128-45ec60b708c2.PNG)

# 주문 승낙

![03_주문승낙](https://user-images.githubusercontent.com/85432029/226529249-c1d3d9c2-b059-40df-8ab2-49a1142da198.PNG)

# 요리 시작

![04_주문시작](https://user-images.githubusercontent.com/85432029/226529253-42cf5bb3-0a01-4e85-9474-6b5593ef6340.PNG)


## CQRS

# 주문 발생
![05_주문발생](https://user-images.githubusercontent.com/85432029/226529257-4a7149f3-db7e-40d7-8d92-7e904e87432d.PNG)

# 상태 변경
![06_상태변경](https://user-images.githubusercontent.com/85432029/226529265-d0d61ea7-6cfd-45a9-9622-56bbd1fcc771.PNG)

# 마이페이지 조회
![07_마이페이지조회](https://user-images.githubusercontent.com/85432029/226529277-f105d6d8-9c75-441f-bedd-095671dc2fab.PNG)


## Model
www.msaez.io/#/storming/e86bb84b957327be1c1959cb8ad0f102

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- customer
- store
- rider
- notify
- mypage


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- customer
```
 http :8088/orders id="id" customerId="customerId" storeId="storeId" foodId="foodId" address="address" status="status" qty="qty" 
```
- store
```
 http :8088/cooks id="id" orderId="orderId" customerId="customerId" address="address" status="status" foodId="foodId" qty="qty" storeId="storeId" 
```
- rider
```
 http :8088/deliveries id="id" orderId="orderId" address="address" status="status" customerId="customerId" storeId="storeId" 
```
- notify
```
 http :8088/notifications id="id" customerId="customerId" status="status" orderId="orderId" 
```
- mypage
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

