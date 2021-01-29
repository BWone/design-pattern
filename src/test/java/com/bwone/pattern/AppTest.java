package com.bwone.pattern;

import static org.junit.Assert.assertTrue;

import com.bwone.pattern.builder.BaseBo;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void compareMatchCode(){
        boolean matchFlag = false;
        int matchFlagCount = 0;
        String sqlMatchChar = "000000000006&80010200";
        String codeMatchChar = "000000000006_80010200_80010200";
        String[] sqlArray = sqlMatchChar.split("&");

        List<String> collect = Arrays.stream(codeMatchChar.split("_")).distinct().collect(Collectors.toList());
        for (String sql : sqlArray) {
            for (String code : collect) {
                matchFlagCount = sql.equals(code) ? ++matchFlagCount : matchFlagCount;
            }
        }
        matchFlag = matchFlagCount >= sqlArray.length;
        System.out.println(matchFlag);
    }

    @Test
    public void collectionTest(){
        String[] strings = {"first", "second", "third"};
        List<String> stringList = Arrays.asList(strings);
        String s1 = stringList.get(0);
        System.out.println(s1);
        stringList.add(0, "new first");
    }

    @Test
    public void BaseBoTest(){
        BaseBo<Object> baseBo = new BaseBo.Builder<>()
                .brain("最强大脑")
                .head(new BaseBo.RequestHead())
                .body("身")
                .toe("金刚脚趾")
                .foot(new BaseBo.RequestFoot())
                .build();

        // 都能获取到值
        BaseBo<BaseBo.RequestHead> headBaseBo = new BaseBo.Builder<BaseBo.RequestHead>()
                .brain("最强大脑")
                .toe("金刚脚趾")
                .build();
        BaseBo.RequestHead head = headBaseBo.getHead();
        BaseBo.RequestFoot food = headBaseBo.getFoot();

        // 只能获取到head值
        BaseBo.RequestHead head1 = new BaseBo.Builder<BaseBo.RequestHead>()
                .brain("最强大脑")
                .buildHead();

        // 只能获取到foot值
        BaseBo.RequestFoot foot1 = new BaseBo.Builder<BaseBo.RequestFoot>()
                .toe("金刚脚趾")
                .brain("sssss")
                .buildFoot();
    }

    @Test
    public void cast(){
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        List<Map<String, String>> strList = new ArrayList<>();
        strList.add(map);
        strList.add(map);
        List<Map<String, Object>> objList = new ArrayList<>();
        Map<String, Object> objMap = new HashMap<>();
        for (Map<String, String> strMap : strList) {
            for (Map.Entry<String, String> str : strMap.entrySet()) {
                objMap.put(str.getKey(), str.getValue());
            }
            objList.add(objMap);
        }
        System.out.println(objList);

        Map<String, String> map1 = new HashMap<>();
        map1.put("a1", "a");
        map1.put("b1", "b");
        map1.put("c1", "c");

    }

    @Test
    public void date() {
        String s = LocalDate.now().toString();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        String s1 = LocalDateTime.now().format(timeFormatter);
        System.out.println(s);
        System.out.println(s1);
    }
}
