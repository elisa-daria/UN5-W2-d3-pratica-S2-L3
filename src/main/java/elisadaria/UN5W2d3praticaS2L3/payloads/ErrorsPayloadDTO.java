package elisadaria.UN5W2d3praticaS2L3.payloads;

import java.time.LocalDateTime;

public record ErrorsPayloadDTO(String msg, LocalDateTime timestamp) {
}
