package hu.unimiskolc.dwa.chat_search;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class ChatMessageController {
    private final ChatMessageRepository repo;

    public ChatMessageController(ChatMessageRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ChatMessage save(@RequestBody ChatMessage m) { return repo.save(m); }

    @GetMapping
    public Iterable<ChatMessage> all() { return repo.findAll(); }

    @GetMapping("/search")
    public List<ChatMessage> search(@RequestParam String text) {
        return repo.findByMessage(text, PageRequest.of(0, 10)).getContent();
    }

    @GetMapping("/sender/{sender}")
    public List<ChatMessage> bySender(@PathVariable String sender) {
        return repo.findBySender(sender, PageRequest.of(0, 10)).getContent();
    }

    // --- 作业 1 接口 ---
    @GetMapping("/room/{roomId}")
    public List<ChatMessage> byRoomId(@PathVariable String roomId) {
        return repo.findByRoomId(roomId, PageRequest.of(0, 10)).getContent();
    }

    // --- 作业 2 接口 ---
    @GetMapping("/search-both")
    public List<ChatMessage> searchBoth(@RequestParam String sender, @RequestParam String message) {
        return repo.findBySenderOrMessage(sender, message, PageRequest.of(0, 10)).getContent();
    }
}