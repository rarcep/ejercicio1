<%@ page import="ejercicio1.Producto" %>



<div class="fieldcontain ${hasErrors(bean: producto, field: 'codigo', 'error')} required">
	<label for="codigo">
		<g:message code="producto.codigo.label" default="Codigo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codigo" required="" value="${producto?.codigo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: producto, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="producto.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${producto?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: producto, field: 'precio', 'error')} required">
	<label for="precio">
		<g:message code="producto.precio.label" default="Precio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="precio" required="" value="${fieldValue(bean: producto, field: 'precio')}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: producto, field: 'proveedor', 'error')} required">
	<label for="proveedor">
		<g:message code="producto.proveedor.label" default="Proveedor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="proveedor" name="proveedor.id" from="${ejercicio1.Proveedor.list()}" optionKey="id" required="" value="${producto?.proveedor?.id}" class="many-to-one"/>
</div>

