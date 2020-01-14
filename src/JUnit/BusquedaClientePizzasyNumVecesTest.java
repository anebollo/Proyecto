package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * esta es la clase para testear el mergesort
 * @author Ane Y aitor
 *
 */
public class BusquedaClientePizzasyNumVecesTest {

	private ArrayList<Integer>Input=new ArrayList<>();
	private ArrayList<String>pizzas=new ArrayList<>();
	@Before
	/**
	 * este es el metodo para inicializar los valores
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		
		//array input
		Input.add(3);
		Input.add(4);
		Input.add(7);
		Input.add(2);
		Input.add(5);
		
		//array pizzas nombres
		pizzas.add("Jamon y queso");
		pizzas.add("Barbacoa");
		pizzas.add("Hawaiiana");
		pizzas.add("4 quesos");
		pizzas.add("Carbonara");
	}

	@Test
	/**
	 * este es el metodo para testear el merge
	 */
	public void testMerge() {
		ArrayList<Integer>numero=logica.presentacion.BusquedaClientePizzasyNumVeces.mergeSort(Input, pizzas);
		
		for(int i=0;i<numero.size();i++) {
			assertSame(2,numero.get(0));
			assertSame(3,numero.get(1));
			assertSame(4,numero.get(2));
			assertSame(5,numero.get(3));
			assertSame(7,numero.get(4));
		}
		
		for(int i=0;i<numero.size();i++) {
			assertNotSame(4,numero.get(0));
			assertNotSame(2,numero.get(1));
			assertNotSame(3,numero.get(2));
			assertNotSame(7,numero.get(3));
			assertNotSame(5,numero.get(4));
		}
	}

	@Test
	public void testMergeSort() {
		fail("Not yet implemented");
	}
	
}
