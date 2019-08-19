package hansol.springelasticsearch;

import hansol.springelasticsearch.model.Phone;
import hansol.springelasticsearch.service.PhoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringElasticsearchApplicationTests {

	@Autowired
	private PhoneService phoneService;

	@Test
	public void data_save() {
		Phone phone = new Phone(1, "010-1234-5678", "hansol");
		Phone testPhone = phoneService.save(phone);

		assertNotNull(testPhone.getId());
		assertThat(testPhone.getNumber(), is(phone.getNumber()));
	}

	@Test
	public void data_get() {
		Phone phone = new Phone(2, "010-9876-5432", "solhan");
		phoneService.save(phone);

		Optional<Phone> testPhone = phoneService.findOne(2);

		System.out.println(testPhone.toString());
		assertNotNull(testPhone);
		assertThat(testPhone.get().getNumber(), is(phone.getNumber()));
	}

}
