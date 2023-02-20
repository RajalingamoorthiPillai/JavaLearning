package in.conceptarchitect.commons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import in.conceptarchitect.animals.birds.Parrot;

public class ReflectionHelper {

	public static List<Method> findSpecialBehavior(Object obj) {
		// TODO Auto-generated method stub
		List<Method> methods= new ArrayList<>();
		
		var cls= obj.getClass();
		
		for(var method : cls.getMethods()) {
			
			if(method.isAnnotationPresent(SpecialBehavior.class))
				methods.add(method);
			
		}
		
		
		return methods;
	}

	public static Object invokeSpeciality(Object object, Object...params) {
		// TODO Auto-generated method stub
		var cls=object.getClass();
		var speciality= cls.getAnnotation(Speciality.class);
		
		if(speciality==null)
			throw new MethodInvocationException(cls.getSimpleName()+" has no speciality");
		
		var behaviorName=speciality.behavior(); //note invoked like method
		
		Method method=null;
		for(var m : cls.getMethods()) {
			if(m.getName().equals(behaviorName)) {
				method=m;
				break;
			}
				
		}
		
		if(method!=null) {
			try {
				return method.invoke(object, params);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				throw new MethodInvocationException( e.getMessage(),e);
			}
		} else {
			throw new MethodInvocationException(cls.getSimpleName()+" has no speciality "+behaviorName, new NoSuchMethodException(behaviorName));
		}
	}

}
