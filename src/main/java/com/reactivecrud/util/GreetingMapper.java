package com.reactivecrud.util;

import com.reactivecrud.dto.GreetingDTO;
import com.reactivecrud.entity.Greeting;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class GreetingMapper {

    public static GreetingDTO greetingToGreetingDTO(Greeting greeting) {
        return new GreetingDTO(greeting.getId(), greeting.getMessage());
    }

    public static Greeting greetingDTOtoGreeting(GreetingDTO greetingDTO) {
        return new Greeting(greetingDTO.id(), greetingDTO.message());
    }
}
