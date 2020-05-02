import android.widget.Button;

import com.example.teachingtasks.CreateUserEventHandler;
import com.example.teachingtasks.Task;

import org.junit.*;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void passwordValidator() {
        CreateUserEventHandler c = new CreateUserEventHandler();

        //Valid
        String good = "Abc123@@";

        //Invalid
        String len_7 = "Abc123@";
        String no_cap = "abc123@@";
        String no_letter = "123456@@";
        String no_special = "Abc12345";
        String no_number = "Abcdef@@";

        assertTrue(c.isAcceptablePassword(good));

        assertFalse(c.isAcceptablePassword(len_7));
        assertFalse(c.isAcceptablePassword(no_cap));
        assertFalse(c.isAcceptablePassword(no_letter));
        assertFalse(c.isAcceptablePassword(no_special));
        assertFalse(c.isAcceptablePassword(no_number));
    }

    @Test
    public void taskTester() {
        UUID id = new UUID(100L, 50L);
        HashMap<String, Button> hm = new HashMap<>();

        Task t = new Task(id, "question",hm);

        t.setQuestionObject("new_question");
        t.setMastery(2);

        assertEquals(id, t.getTaskID());
        assertEquals("new_question",t.getQuestionObject());
        assertEquals(2, t.getMastery());

    }

}
