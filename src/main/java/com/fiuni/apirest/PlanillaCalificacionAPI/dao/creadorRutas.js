//node index.js Base base > base/base.java

const crear = (nombres) => {
    return nombres.map(nombre => {
        const mayuscula = nombre.replace(nombre.at(0), nombre.at(0).toUpperCase());
        return `node index.js ${nombre} ${mayuscula} > ${nombre}/${mayuscula}.java`
    }).join("\n");
}

console.log(crear(["ciclo", "clase", "colegio", "contactoEmergencias", "detalleInforme", "detallePA", "detallePN", "dia", "etapa", "evaluacion", "horaCatedra", "horaProfe", "informe", "listaAlumno", "listaMateria", "materia", "persona", "planClase", "planillaAsistencia", "planillaNota", "rol"]));