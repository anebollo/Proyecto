package logica.negocios;

/**
 * 
 * @author aitor y ane Clase Empleado que es el "padre" de todos los empleados
 *         anteriormente comentados
 */
public abstract class Empleado {

	private String Dni;
	private int sueldo;
	private int horasDia;

	public Empleado() {

	}

	/**
	 * Los atributos de empleado
	 * 
	 * @param dni
	 *            del empleado
	 * @param sueldo
	 *            del empleado
	 * @param horasDia
	 *            que pasa el empleado trabajando
	 */
	public Empleado(String dni, int sueldo, int horasDia) {
		super();
		this.Dni = dni;
		this.sueldo = sueldo;
		this.horasDia = horasDia;
	}

	/**
	 * Obtiene el dni del empleado
	 * 
	 * @return el dni del empleado
	 */
	public String getDni() {
		return Dni;
	}

	/**
	 * Establece el dni al empleado
	 * 
	 * @param dni
	 *            del empleado
	 */
	public void setDni(String dni) {
		Dni = dni;
	}

	/**
	 * Obtiene el sueldo del empleado
	 * 
	 * @return sueldo del empleado
	 */
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * Establece el sueldo al empleado
	 * 
	 * @param sueldo
	 *            del empleado
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Obtiene las horas al dia que trabaja el empleado
	 * 
	 * @return las horas al dia
	 */
	public int getHorasDia() {
		return horasDia;
	}

	/**
	 * Establece las horas al empleado
	 * 
	 * @param horasDia
	 *            del empleado
	 */
	public void setHorasDia(int horasDia) {
		this.horasDia = horasDia;
	}

}
