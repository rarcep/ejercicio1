class BootStrap {

    def springSecurityService
    def sessionFactory

    def init = { servletContext ->
        log.info "Iniciando Aplicación"
        
        log.info "Creando rol Admin"
        def roleAdmin = ejercicio1.Rol.findByAuthority('ROLE_ADMIN') ?: new ejercicio1.Rol(authority: 'ROLE_ADMIN').save(failOnError: true)

        log.info "Creando usuario Admin"
        def admin = ejercicio1.Usuario.findByUsername('admin')
        if (!admin){
            admin = new ejercicio1.Usuario(
                username : 'admin'
                , password : 'admin'
                , nombre : 'romeo'
                , apellido : 'Arce'
                , fechaNacimiento : new Date()
                , correo : 'rarcep@gmail.com'
                , telefono : '8261250472'
                , enabled : true                
            ).save(failOnError: true)
        }
        
        log.info "Creando Relacion rol usuario"
        if (!admin.authorities.contains(roleAdmin)){
            ejercicio1.UsuarioRol.create(admin, roleAdmin)
        }
        
        log.info "Aplicación Iniciada Correctamente"
    }
}
