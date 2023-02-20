package testapp13.reflection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.animals.Hunter;
import in.conceptarchitect.animals.birds.Parrot;
import in.conceptarchitect.animals.mammals.Camel;
import in.conceptarchitect.animals.mammals.Cat;
import in.conceptarchitect.animals.mammals.Horse;
import in.conceptarchitect.animals.mammals.Leopard;
import in.conceptarchitect.animals.mammals.Tiger;
import in.conceptarchitect.commons.MethodInvocationException;
import in.conceptarchitect.commons.ReflectionHelper;

public class ReflectionTests {
	
	Class cls;
	Tiger t1;
	Tiger t2;

	@Before
	public void setUp() throws Exception {
		t1=new Tiger();
		t2=new Tiger();
		cls=t1.getClass();
	}

	@Test
	public void canGetClassInfoFromClassName() {
		var c1= Tiger.class;
		
		assertTigerClass(c1);
	}

	private void assertTigerClass(Class c1) {
		assertTrue(c1 instanceof Class);
		assertEquals("in.conceptarchitect.animals.mammals.Tiger",c1.getName());
		assertEquals("Tiger", c1.getSimpleName());
	}
	
	
	@Test
	public void canGetClassInfoFromObject() {
		var t1=new Tiger();
		var c1=t1.getClass();
		assertTigerClass(c1);
	}
	
	@Test
	public void canGetClassInfoFromPackageQualifiedNameString() throws ClassNotFoundException {
		
		var c1=Class.forName("in.conceptarchitect.animals.mammals.Tiger");
		assertTigerClass(c1);
	}
	
	@Test(expected=ClassNotFoundException.class)
	public void classForNameThrowsClassNotFoundExceptionForBadString() throws ClassNotFoundException {
		
		var c1=Class.forName("a.type.that.doesnt.exist.InvalidClass");
		assertTigerClass(c1);
	}
	
	
	@Test
	public void singleClassObjectIsCreatedPerClass() {
		var c1=Tiger.class;
		var c2= new Tiger().getClass();
		var c3=new Tiger().getClass();
		
		assertEquals(c1.hashCode(),c2.hashCode());
		assertEquals(c2.hashCode(),c3.hashCode());
	}
	
	
	@Test
	public void classInfoContainsInformationAboutSuperClass() {
		
		var superClass = cls.getSuperclass();
		
		assertEquals(Cat.class, superClass);
		
	}
	
	@Test
	public void canAccessTheImplementedInterfacesOfAClass() {
		var interfaces= cls.getInterfaces();
		
		//return list of interfaces implemented by this class directly
		//inherited interfaces are not counted
		assertEquals(0, interfaces.length);
	}
	
	@Test
	public void canAccessTheImplementedInterfacesOfClassHorse() {
		var interfaces= Horse.class.getInterfaces();		
		
		assertEquals(2, interfaces.length);	
		
	}
	
	@Test
	public void canReferToInterfacesUsingClassReference() {
		var cls= Hunter.class;
		
		assertTrue(cls.isInterface());
		assertEquals("in.conceptarchitect.animals.Hunter", cls.getName());
	}
	
	@Test
	public void aTigerCanHuntEvenWithObjectReferece() throws NoSuchMethodException, SecurityException, 
																IllegalAccessException, IllegalArgumentException, 
																InvocationTargetException, ClassNotFoundException, 
																InstantiationException {
		
		//Get class reference
		Class cls = Class.forName("in.conceptarchitect.animals.mammals.Tiger");
		
		
		//Object obj=cls.newInstance();
		
		Object obj = cls.getConstructor().newInstance();
		
		
		//var result= obj.hunt();
		
		//get the hunt method of the object
		//if not found will throw NoSuchMethodException
		Method hunt = obj.getClass().getMethod("hunt");
		
		//invoke the method to get the result
		
		var result = hunt.invoke(obj);
		
		assertEquals("Tiger hunts in jungle", result);
		
	}
	
	@Test
	public void weCanDetermineAtRuntimeIfAMethodDoesntExistInClass() {
		
		var horse = new Horse();
		
		assertThrows(NoSuchMethodException.class, ()->{
			var hunt = horse.getClass().getMethod("hunt");
			
		});
		
	}
	
	@Test
	public void findSpecialBehaviorReturnsAnArrayOfSpecialBehavior() {
		
		List<Method> behaviors= ReflectionHelper.findSpecialBehavior(t1);
		
		assertEquals(1, behaviors.size());
		
		assertEquals("hunt", behaviors.get(0).getName());
	}

	
	@Test
	public void camelHasNoSpecialBehavior() {
		var camel=new Camel();
		List<Method> behaviors= ReflectionHelper.findSpecialBehavior(camel);
		
		
		assertEquals(0, behaviors.size());
	}
	
	
	@Test
	public void parrotHasTwoSpecialBehaviors() {
		
		var parrot=new Parrot();
		var behaviors= ReflectionHelper.findSpecialBehavior(parrot);
		
		System.out.println(behaviors);
		
		assertEquals(2, behaviors.size());
		
	}
	
	
	@Test
	public void canInvokeSpecialBehaviorOfParrot() {
		var parrot=new Parrot();
		
		var result = ReflectionHelper.invokeSpeciality(parrot);
		
		assertEquals("Parrot can speak like human",result);
	}
	
	@Test
	public void throwsMethodInvocationExceptionIfNoSpecialityPresent() {
		
		var ex= assertThrows(MethodInvocationException.class, ()->{
			ReflectionHelper.invokeSpeciality(new Camel());
		});
		
		
		assertEquals("Camel has no speciality",ex.getMessage());
		
		
	}
	
	
	
	@Test
	public void throwsMethodInvocationExceptionIfSpecialityBehaviorIsNotPresent() {
		var ex=assertThrows(MethodInvocationException.class,()->{
			var leopard=new Leopard();
			var result= ReflectionHelper.invokeSpeciality(leopard);
		});
		
		assertEquals(NoSuchMethodException.class, ex.getCause().getClass());
		
		assertEquals("Leopard has no speciality fly", ex.getMessage());
	}
	
	@Ignore
	@Test(expected=NoSuchMethodException.class)
	public void throwsNoSuchMethodException() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		t1.getClass().getMethod("fly").invoke(t1);
	}
	
	@Test
	public void throwsNoSuchMethodExceptionUsingAssertThrows()  {
		assertThrows(NoSuchMethodException.class, ()->{
			t1.getClass().getMethod("fly").invoke(t1);	
		});
		
	}
}
