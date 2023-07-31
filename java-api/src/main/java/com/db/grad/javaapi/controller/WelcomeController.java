
import org.springframework.web.bind.annotation.GetMaimport org.springframework.web.bind.annotation.RestController;

@RestController
public class Welc
  @GetMapping("/status")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }

}