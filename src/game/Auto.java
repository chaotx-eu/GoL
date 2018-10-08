package game;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class Auto {

	@Getter
	@Setter(AccessLevel.PRIVATE)
	String hers;

}
