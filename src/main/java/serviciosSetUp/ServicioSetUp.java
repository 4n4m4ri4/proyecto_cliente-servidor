package serviciosSetUp;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categoria;
import modelo.Joya;
import modelo.SetUp;
import modelo.Usuario;

//utilidad para preparar unos registros

@Service
@Transactional
public class ServicioSetUp implements InterfazSetUp{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void setUp() {
		Criteria c = 
				sessionFactory.getCurrentSession().
					createCriteria(SetUp.class);
		if ( c.list().size() == 0 ) {
			//preparamos unos registros
			sessionFactory.getCurrentSession().save( 
					new Usuario("ares", "pepito",30,"ares@gmail.com","123") 
				);
			sessionFactory.getCurrentSession().save( 
					new Usuario("ana", "logo",24,"ana@gmail.com","123") 
				);
			sessionFactory.getCurrentSession().save( 
					new Usuario("llona", "lonas",20,"llona@gmail.com","123") 
				);
			
			//categorias
			Categoria collar = new Categoria("collar");
			sessionFactory.getCurrentSession().save(
					collar
					);
			Categoria pendiente = new Categoria("pendiente");
			sessionFactory.getCurrentSession().save(
					pendiente
					);
			Categoria pulsera=new Categoria("pulsera");
			sessionFactory.getCurrentSession().save(
					pulsera
					);
			Categoria anillo=new Categoria("anillo");
			sessionFactory.getCurrentSession().save(
					anillo
					);
			
			
			
			//joyas
			sessionFactory.getCurrentSession().save(
					new Joya("Pulsera mujer oro 24k", 80, "oro",40,"Tous", "dorado",pulsera,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Pendientes mujer plata ", 20, "plata",20,"Tous", "plateado",pendiente,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Collar Trébol Lotus Silver", 23.30, "plata",30,"Lotus", "plateado",collar,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Pulsera Lotus Style LS1885-2/1", 40, "plata",30,"Tous", "plateado",pulsera,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Anillo Lotus Silver Pure Essential",29,"plata",30,"Lotus","plateado",anillo,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Anillo Time Road AF00012/12",72,"oro",30,"Lotus","dorado",anillo,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Anillo Lotus Silver Pure Essential LP3444-3/118",39,"plata",30,"Lotus","plateado",anillo,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Pendientes Mariposa Lotus Style",12.90,"plata",10,"Lotus","plateado",pendiente,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Collar Infinito Lotus Silver Trendy",27.20,"plata",30,"Lotus","plateado",collar,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Collar Time Road IC00307/43",79,"oro",30,"TimeRoad","dorado",collar,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Collar Corazón Lotus Silver Trendy",31.20,"plata",27,"Lotus","plateado",collar,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Pendientes Estrellas Lotus Silver Trendy",23.50,"plata",2,"Lotus","plateado",pendiente,true)
					);
			sessionFactory.getCurrentSession().save(
					new Joya("Pendientes Time Road ",55,"oro",0.55,"TimeRoad","dorado",pendiente,true)
					);
			for (int i = 0; i < 10; i++) {
				String nombre = "Pulsera mujer con corazones ";
				sessionFactory.getCurrentSession().save(
						new Joya(nombre, 80, "oro",40,"Tous", "dorado",pulsera,true)
						);
			}
			//setup completado
			SetUp setUp = new SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);
			
			
		} //end if
		
	}//end setUp
	
}







