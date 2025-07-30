package com.boluo.langchain4jboluoai;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestUploadKnowledgeLibrary {

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    @Autowired
    private EmbeddingModel embeddingModel;
    @Test
    public void testUploadKnowledgeLibraryhere() {

        //使用FileSystemDocumentLoader读取指定目录下的知识库文档
        //并使用默认的文档解析器对文档进行解析
        Document document1 = FileSystemDocumentLoader.loadDocument("D:\\newCode\\AI\\java-ai-langchain4j-medical-main\\ragDoc\\医院信息.md");
        Document document2 = FileSystemDocumentLoader.loadDocument("D:\\newCode\\AI\\java-ai-langchain4j-medical-main\\ragDoc\\科室信息.md");
        Document document3 = FileSystemDocumentLoader.loadDocument("D:\\newCode\\AI\\java-ai-langchain4j-medical-main\\ragDoc\\神经内科.md");
        List<Document> documents = Arrays.asList(document1, document2, document3);

        //文本向量化并存入向量数据库：将每个片段进行向量化，得到一个嵌入向量
        EmbeddingStoreIngestor
                .builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .build()
                .ingest(documents);
    }
}
