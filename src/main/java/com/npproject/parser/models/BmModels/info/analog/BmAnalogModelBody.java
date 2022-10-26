package com.npproject.parser.models.BmModels.info.analog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmAnalogModelBody {
    private String id;
    private AnalogInfo analogs;
}
