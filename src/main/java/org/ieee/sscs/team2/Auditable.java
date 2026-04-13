package org.ieee.sscs.team2;

import java.time.Instant;

public interface Auditable {
  /** Timestamp when this entity was first created. Immutable. **/
  Instant getCreatedAt();
}
