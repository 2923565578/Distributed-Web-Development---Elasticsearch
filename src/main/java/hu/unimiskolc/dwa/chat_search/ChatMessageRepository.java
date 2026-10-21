package hu.unimiskolc.dwa.chat_search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ChatMessageRepository extends ElasticsearchRepository<ChatMessage, String> {
    Page<ChatMessage> findBySender(String sender, Pageable pageable);
    Page<ChatMessage> findByMessage(String message, Pageable pageable);
    
    // 作业 1：按房间查
    Page<ChatMessage> findByRoomId(String roomId, Pageable pageable);
    
    // 作业 2：多字段联合查（Sender 或 Message）
    Page<ChatMessage> findBySenderOrMessage(String sender, String message, Pageable pageable);
}