package org.powermock.modules.spock.rule

import org.junit.Rule
import spock.lang.Specification
/**
 * Created by qixiang.mft Jun 2017
 * @author qixiang.mft
 * @date 2017/06/29
 */
class SpecificationWithPowerMock extends Specification{
    @Rule
    public SpockPowerMockRule rule = new SpockPowerMockRule()
}
