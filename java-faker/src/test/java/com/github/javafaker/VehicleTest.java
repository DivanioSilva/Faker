package com.github.javafaker;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * @author Divanio Silva (divanios@icloud.com)
 */
public class VehicleTest extends AbstractFakerTest {

    @Test
    public void quote() {
        Assertions.assertNotNull(faker.vehicle());
        Assertions.assertNotNull(faker.vehicle().manufacture());
        Assertions.assertTrue(StringUtils.isNotEmpty(faker.vehicle().manufacture()));
        Assertions.assertTrue(StringUtils.isNotEmpty(faker.bothify("?? ## ??").toUpperCase()));
    }
}
