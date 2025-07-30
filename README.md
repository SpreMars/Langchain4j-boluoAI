# Langchain4j-boluoAI
基于Langchain4j和Springboot开发的agent

## 项目架构
该项目采用Spring Boot作为基础框架，构建RESTful API服务。核心功能围绕Langchain4j构建，实现了与多种大语言模型的集成，包括OpenAI、Ollama和阿里云百炼平台。数据持久化层使用MyBatis-Plus操作关系型数据库（MySQL），同时集成MongoDB用于非结构化数据存储。项目还包含文档解析（如PDF）、向量存储（Qdrant）和流式响应（WebFlux）等功能模块，通过Knife4j提供API文档支持。

## 技术栈
- **核心框架**: Spring Boot 3.2.6
- **AI集成**: Langchain4j 1.0.0-beta3 (支持OpenAI、Ollama、阿里云百炼)
- **数据库**: 
  - MySQL (通过MyBatis-Plus 3.5.11)
  - MongoDB
- **API文档**: Knife4j 4.3.0
- **文档处理**: Apache PDFBox
- **向量存储**: Qdrant
- **响应式编程**: Spring WebFlux
- **构建工具**: Maven
