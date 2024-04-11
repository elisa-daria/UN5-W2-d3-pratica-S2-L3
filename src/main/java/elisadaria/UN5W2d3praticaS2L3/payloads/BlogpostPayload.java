package elisadaria.UN5W2d3praticaS2L3.payloads;

public record BlogpostPayload(
         String category,
         String title,
         String content,
         double readingTime,
         int author_id) {
}
