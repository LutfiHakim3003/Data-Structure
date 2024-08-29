import 'dart:io';

class Product {
  final String name;
  final double price;
  final int quantity;

  Product(this.name, this.price, this.quantity);
}

void main() {
  List<Product> cart = [];
  List<Product> products = [
    Product("Apple", 2.5, 10),
    Product("Banana", 1.0, 20),
    Product("Orange", 1.5, 15),
  ];

  while (true) {
    print("\nMenu:");
    print("1. Add Product to Cart");
    print("2. View Cart");
    print("3. Checkout");
    print("4. Exit");
    print("Enter your choice:");

    String choice = stdin.readLineSync()!;
    switch (choice) {
      case '1':
        addProductToCart(products, cart);
        break;
      case '2':
        viewCart(cart);
        break;
      case '3':
        checkout(cart);
        break;
      case '4':
        exit(0);
      // break;
      default:
        print("Invalid choice. Please try again.");
    }
  }
}

void addProductToCart(List<Product> products, List<Product> cart) {
  print("\nAvailable Products:");
  for (var i = 0; i < products.length; i++) {
    print("${i + 1}. ${products[i].name} - \$${products[i].price}");
  }

  print("Enter the product number to add to cart:");
  int productIndex = int.parse(stdin.readLineSync()!) - 1;

  if (productIndex >= 0 && productIndex < products.length) {
    print("Enter quantity:");
    int quantity = int.parse(stdin.readLineSync()!);
    if (quantity <= products[productIndex].quantity) {
      Product selectedProduct = Product(
          products[productIndex].name, products[productIndex].price, quantity);
      cart.add(selectedProduct);
      print("Product added to cart.");
    } else {
      print("Insufficient stock.");
    }
  } else {
    print("Invalid product number.");
  }
}

void viewCart(List<Product> cart) {
  if (cart.isEmpty) {
    print("Cart is empty.");
  } else {
    print("\nCart:");
    double totalPrice = 0;
    for (var i = 0; i < cart.length; i++) {
      print(
          "${i + 1}. ${cart[i].name} - ${cart[i].quantity} x \$${cart[i].price}");
      totalPrice += cart[i].price * cart[i].quantity;
    }
    print("Total: \$${totalPrice.toStringAsFixed(2)}");
  }
}

void checkout(List<Product> cart) {
  if (cart.isEmpty) {
    print("Cart is empty. Nothing to checkout.");
  } else {
    viewCart(cart);
    print("Thank you for shopping with us!");
    cart.clear();
  }
}
