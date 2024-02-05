import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/list_user_contoller.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_routes.dart';

class UserListPage extends StatelessWidget {
  final UserListController userListController = Get.put(UserListController());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista de Usuários'),
        actions: [
          IconButton(
            icon: Icon(Icons.add),
            onPressed: () {
              // Navegue para a página de adição de usuário
              Get.toNamed(Routes.ADD_USER);
            },
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // TextField(
            //   controller: userListController._searchController,
            //   decoration: InputDecoration(
            //     labelText: 'Pesquisar',
            //     suffixIcon: Icon(Icons.search),
            //   ),
            // ),
            SizedBox(height: 20),
            Obx(() {
              return DataTable(
                columns: [
                  DataColumn(label: Text('Username')),
                  DataColumn(label: Text('Email')),
                  DataColumn(label: Text('Role')),
                  DataColumn(label: Text('Ações')),
                ],
                rows: userListController.userList.map((user) {
                  return DataRow(
                    cells: [
                      DataCell(Text(user.username)),
                      DataCell(Text(user.email)),
                      DataCell(Text(user.role)),
                      DataCell(
                        Row(
                          children: [
                            IconButton(
                              icon: const Icon(Icons.edit),
                              onPressed: () {
                                userListController.editUser(user);
                              },
                            ),
                            IconButton(
                              icon: const Icon(Icons.delete),
                              onPressed: () {
                                userListController
                                    .showDeleteConfirmationDialog(user);
                              },
                            ),
                            IconButton(
                              icon: const Icon(Icons.info),
                              onPressed: () {
                                // Chame o método para mostrar a modal de detalhes do usuário
                                userListController.showUserDetailsModal(user);
                              },
                            ),
                          ],
                        ),
                      ),
                    ],
                  );
                }).toList(),
              );
            }),
          ],
        ),
      ),
    );
  }
}
