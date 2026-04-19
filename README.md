![Java](https://img.shields.io/badge/Java-17-blue)
![JUnit 5](https://img.shields.io/badge/JUnit5-5.10.2-yellow)
![Cucumber](https://img.shields.io/badge/Cucumber-7.20.1-green)
![Selenium](https://img.shields.io/badge/Selenium-4.27.0-purple)

# 🥒 Cucumber + Selenium Web 自动化测试框架

基于 Cucumber BDD 框架和 Selenium WebDriver 的 Web UI 自动化测试项目。

## 🏗️ 技术栈
Java 17 | Cucumber | Selenium | JUnit 5 | Lombok | Maven

## 📁 项目结构
src/test/java/com/goosying/cucumber/  
├── common/ # WebDriver 管理  
├── enums/ # 业务枚举  
├── pages/ # Page Object 页面对象  
├── runner/ # 测试运行器  
├── steps/ # Step Definitions 步骤定义  
└── utils/ # 工具类  

src/test/resources/  
├── config/ # 配置文件  
└── features/ # Gherkin 用例文件  


## ✨ 框架亮点

### 🥒 BDD 行为驱动开发
使用 Gherkin 语法编写自然语言风格的测试用例，业务人员也能轻松阅读理解。

### 🔀 CI/CD 自动化
测试已集成 GitHub Actions  

[![UI Tests](https://github.com/Roxy-MG/cucumber-selenium-web-tests/actions/workflows/ui-tests.yml/badge.svg)](https://github.com/Roxy-MG/cucumber-selenium-web-tests/actions/workflows/ui-tests.yml)
### ⚡支持并发
PicoContainer 确保多线程下实例隔离，runner文件配置全局并发。

### 📄 Page Object 设计模式
采用 POM 页面对象模式，页面元素与测试逻辑分离，提高可维护性。

### 🧩 模块化架构
WebDriver 管理、页面对象、步骤定义、工具类分层清晰，职责单一。

### 🔄 Cucumber 报告
自动生成结构化的 Cucumber 测试报告，直观展示用例执行结果。

## ▶️ 如何运行
```bash
mvn clean test
```

## 📂 报告位置
target/cucumber-reports/
