package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.airfrance;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Origin {
    String type;
    String code="CITY";

        public Origin(String type, String code) {
            this.type = type;
            this.code = code;
        }
    }
