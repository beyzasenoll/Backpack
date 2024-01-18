package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.airfrance;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Origin {
    String type;
    String code;

        public Origin(String type, String code) {
            this.type = type;
            this.code = code;
        }
    }
