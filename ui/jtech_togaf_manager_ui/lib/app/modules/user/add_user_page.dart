import 'package:flutter/material.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/user.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/user_controller.dart';

class AddUserPage extends StatefulWidget {
  @override
  _AddUserPageState createState() => _AddUserPageState();
}

class _AddUserPageState extends State<AddUserPage> {
  final UserController _userController = UserController();
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  String _selectedRole = 'ADMIN';
  TextEditingController _usernameController = TextEditingController();
  TextEditingController _passwordController = TextEditingController();
  TextEditingController _emailController = TextEditingController();

  List<String> _roles = [
    'ADMIN',
    'ANALYST',
    'ARCHITECT',
    'PRODUCT_OWNER',
    'DEVELOPER',
    'PROJECT_MANAGER',
  ];

  @override
  void dispose() {
    _usernameController.dispose();
    _passwordController.dispose();
    _emailController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
        title: Text('Adicionar Usuário'),
        content: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              TextFormField(
                controller: _usernameController,
                decoration: InputDecoration(labelText: 'Username'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    // Verifique se o valor é nulo ou vazio
                    return 'Campo obrigatório';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _passwordController,
                obscureText: true,
                decoration: InputDecoration(labelText: 'Password'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    // Verifique se o valor é nulo ou vazio
                    return 'Campo obrigatório';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _emailController,
                decoration: InputDecoration(labelText: 'Email'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    // Verifique se o valor é nulo ou vazio
                    return 'Campo obrigatório';
                  }
                  return null;
                },
              ),
              DropdownButtonFormField<String>(
                value: _selectedRole,
                items: _roles.map((role) {
                  return DropdownMenuItem<String>(
                    value: role,
                    child: Text(role),
                  );
                }).toList(),
                onChanged: (value) {
                  setState(() {
                    _selectedRole = value ?? '';
                  });
                },
                decoration: InputDecoration(labelText: 'Role'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    // Verifique se o valor é nulo ou vazio
                    return 'Campo obrigatório';
                  }
                  return null;
                },
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    User newUser = User(
                      id: "0",
                      username: _usernameController.text,
                      password: _passwordController.text,
                      email: _emailController.text,
                      role: _selectedRole,
                    );

                    _userController.addUser(newUser);

                    _usernameController.clear();
                    _passwordController.clear();
                    _emailController.clear();

                    Navigator.of(context).pop();
                  }
                },
                child: Text('Adicionar Usuário'),
              ),
            ],
          ),
        ));
  }
}
