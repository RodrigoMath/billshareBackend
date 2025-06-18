package com.billshare.backend.domain.checkinContext.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckinSummaryDTO {
    private String userName;
    private Long totalCheckins;
}