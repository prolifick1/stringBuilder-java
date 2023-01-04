package Interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAnagrams {

    @Test
    public void test() {
        Anagrams a = new Anagrams();
        var actual = a.groupByAnagram("лох пидр хол мол рдип пдир");
        Map<String, List<String>> expected = new HashMap<>() {{
            put("лох", List.of("лох", "хол"));
            put("дипр", List.of("пидр", "рдип", "пдир"));
            put("лмо", List.of("мол"));
        }};

        Assert.assertEquals(expected, actual);
    }
}
