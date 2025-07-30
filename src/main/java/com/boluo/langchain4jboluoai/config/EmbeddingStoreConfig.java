package com.boluo.langchain4jboluoai.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.qdrant.QdrantEmbeddingStore;
import io.qdrant.client.QdrantClient;
import io.qdrant.client.QdrantGrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddingStoreConfig {

    @Autowired
    private EmbeddingModel embeddingModel;


    @Bean
    public QdrantClient qdrantClient(){
        QdrantGrpcClient.Builder grpcClientBuilder = QdrantGrpcClient.newBuilder("localhost",6334,false);
        return new QdrantClient(grpcClientBuilder.build());
    }
    @Bean
    public EmbeddingStore<TextSegment> embeddingStore() {
        // 创建向量存储
        EmbeddingStore<TextSegment> embeddingStore = QdrantEmbeddingStore.builder()
                .host("localhost")
                .port(6334)
                .collectionName("boluoAI")
                .build();
        return embeddingStore;
    }
}
