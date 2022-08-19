package jpabook.jpashop;

//import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

//	@Bean
//	Hibernate5Module hibernate5Module() {
//		return new Hibernate5Module();
//	} // _> 기본적으로 초기화 된 프록시 객체만 노출,
//		// 초기화 되지 않은 프록시 객체는 노출 안함

//	@Bean	//다음과 같이 설정하면 강제로 지연 로딩 가능
//	Hibernate5Module hibernate5Module() {
//		Hibernate5Module hibernate5Module = new Hibernate5Module();
//		//강제 지연 로딩 설정
//		hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,
//				true);
//		return hibernate5Module;
//	}
	//order -> member , member -> orders 양방향 연관관계를 계속 로딩하게 된다. 따라서
	//@JsonIgnore 옵션을 한곳에 주어야 한다.
	// 엔티티 api로 외부노출 좋지않음 -> Hibernate5Module 를 사용하기 보다
	// 는 DTO로 변환해서 반환하는 것이 더 좋은 방법

	//+) 항상 지연 로딩을 기본으로 하고,
	// 최적화가 필요한 경우에는 페치 조인(fetch join)을 사용
}
