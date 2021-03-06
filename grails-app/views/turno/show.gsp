<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="pasalabocha" />
        <g:set var="entityName" value="${message(code: 'turno.label', default: 'Turno')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-turno" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>         </ul>
        </div>
        <div id="show-turno" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <fieldset class="turno">
              <label>Fecha: <f:display bean="turno" property="fechaHorario"/></label><br>
              <label>Duración: <f:display bean="turno" property="duracion"/></label><br>
              <label>Precio: <f:display bean="turno" property="precioBase"/></label><br>
              <g:if test="${this.turno.reserva == null}">
              <label>Disponibilidad: Libre</label><br>
              </g:if>
              <g:else>
              <label>Disponibilidad: Ocupado</label><br>
              </g:else>
            </fieldset>

            <g:form resource="${this.turno}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.turno}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
