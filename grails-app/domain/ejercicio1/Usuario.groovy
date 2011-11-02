package ejercicio1

class Usuario {

	transient springSecurityService

	String username
	String password
        String nombre
        String apellido
        Date fechaNacimiento
	String correo
	String telefono
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
                nombre (blank:false)
                apellido (blank:false)
                correo(blank:false, email:true)
		fechaNacimiento()
		telefono(matches:"[0-9]{10}", blank:false)
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Rol> getAuthorities() {
		UsuarioRol.findAllByUsuario(this).collect { it.rol } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
