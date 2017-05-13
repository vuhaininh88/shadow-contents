package com.uzabase.shadow.cache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.inject.Named;

/**
 * Created by Trung Vu on 2017/05/13.
 */
@Named
@Getter
@Setter
@ToString
@EqualsAndHashCode
@ConfigurationProperties("config")
public class CacheDuration {

    private Integer duration;
}
