![Java](https://img.shields.io/badge/Java-17-blue)
![Cucumber](https://img.shields.io/badge/Cucumber-7.20.1-green)
# Cucumber + Selenium 自动化测试框架

## 项目简介
基于 Cucumber BDD 框架和 Selenium WebDriver 的 Web 自动化测试项目，用于 SauceDemo 网站的测试。

## 技术栈
- Java 17
- Cucumber 7.20.1 (BDD)
- Selenium 4.27.0
- JUnit 5 
- Maven
- Lombok

## 项目结构
├── src/  
│ ├── main/  
│ │ └── java/  
│ └── test/  
│ ├── java/  
│ │ └── com/goosying/cucumber/  
│ │ ├── common/ # WebDriver 管理  
│ │ ├── enums/ # 业务枚举  
│ │ ├── pages/ # Page Object  
│ │ ├── runner/ # 测试运行器  
│ │ ├── steps/ # Step Definitions  
│ │ └── utils/ # 工具类  
│ └── resources/  
│ ├── config/ # 配置文件  
│ └── features/ # Gherkin 用例  
├── pom.xml  
└── README.md  

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+

### 运行测试
```bash
mvn clean test
```
### 报告位置
- target/cucumber-reports/
