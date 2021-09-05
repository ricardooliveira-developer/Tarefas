package br.com.ricardo.developer.tarefas.banco.scripts.cadastro

fun tabelaTarefas(): String {
    return "CREATE TABLE IF NOT EXISTS [tarefas](\n" +
            "                 [id] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
            "                 [nome] TEXT NOT NULL,\n" +
            "                 [data] TEXT NOT NULL,\n" +
            "                 [hora] TEXT NOT NULL);"
}

fun selectRetornaTarefas(tabela: String): String {
    return "SELECT * FROM $tabela"
}
