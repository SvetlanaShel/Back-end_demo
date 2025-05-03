package de.ait;

/*
{
    "result": {
        "text": [

                },
                "data": "ОТВЕЧАЮ"
            },

                },
                "data": "В СПРИНГЕ ЭТО УЖЕ ЕСТЬ"
            }
        ]
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class ResultDto {
    private List<TextDto> text;
}
