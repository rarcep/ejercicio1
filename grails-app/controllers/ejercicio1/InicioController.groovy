package ejercicio1

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])

class InicioController {

def index = { }
}
