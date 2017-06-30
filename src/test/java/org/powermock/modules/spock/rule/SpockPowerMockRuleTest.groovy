package org.powermock.modules.spock.rule

import com.google.common.eventbus.EventBus
import org.powermock.core.classloader.annotations.PrepareForTest
/**
 * Created by qixiang.mft 六月 2017
 * @author qixiang.mft
 * @date 2017/06/30
 */
@PrepareForTest(EventBus)
class SpockPowerMockRuleTest extends SpecificationWithPowerMock {
    def "test" () {
        expect:
        1==1
    }
}
