package com.example.deliveryservice.database.util

import com.example.deliveryservice.R
import com.example.deliveryservice.database.entity.Restaurant

fun provideRestaurantList() : List<Restaurant> {
    return listOf(
        Restaurant(
            name = "Burger King",
            picture = R.drawable.burgerking,
            description = "Burger King — это одна из крупнейших сетей ресторанов быстрого питания в мире, известная своими вкусными и сытными бургерами, приготовленными на гриле. С момента своего основания в 1954 году, Burger King стал символом качественного фастфуда, который завоевал признание миллионов людей по всему миру благодаря своему уникальному подходу к приготовлению блюд.\n" +
                    "\n" +
                    "Основное меню Burger King включает:\n" +
                    "- Бургеры с уникальной технологией приготовления на гриле, включая знаменитый Whopper.\n" +
                    "- Картошка фри, хрустящая снаружи и мягкая внутри.\n" +
                    "- Куриные крылышки и наггетсы с различными соусами.\n" +
                    "- Десерты и напитки для завершения трапезы.\n" +
                    "\n" +
                    "Burger King — это место, где можно насладиться вкусной едой, приготовленной с заботой и вниманием к качеству, в любой момент и в любом месте."
        ),
        Restaurant(
            name = "Papa Doner",
            picture = R.drawable.papadoner,
            description = "Papa Doner — это популярная сеть заведений быстрого питания в Беларуси, специализирующаяся на приготовлении донеров, шаурмы и других блюд с использованием свежих и качественных ингредиентов. Заведение привлекает посетителей своим разнообразным меню, где каждый найдет что-то по вкусу, от классических мясных донеров до более оригинальных сочетаний с овощами и соусами.\n" +
                    "\n" +
                    "Среди популярных позиций на меню Papa Doner можно выделить:\n" +
                    "- Донер с курицей, говядиной или бараниной, подается с различными соусами, такими как чесночный, барбекю и терияки.\n" +
                    "- Донер с беконом или с картошкой фри для тех, кто любит более насыщенные и сытные блюда.\n" +
                    "- В кафе также можно найти свежие салаты и другие блюда для более легких перекусов.\n" +
                    "\n" +
                    "Кроме того, Papa Doner предлагает услуги доставки, что делает их блюда доступными для заказа на дом. Заведение ценится за свою доступность и качественное обслуживание, что делает его популярным выбором среди жителей Минска и гостей города.\n" +
                    "\n" +
                    "Если ты ищешь быстрое, вкусное и сытное блюдо, Papa Doner — отличное место для любителей шаурмы и донеров."
        ),
        Restaurant(
            name = "Mak.by",
            picture = R.drawable.mak,
            description = "Mak.by — это современный ресторан быстрого питания, который предлагает широкий ассортимент вкусных блюд, приготовленных из качественных ингредиентов. Уютная атмосфера, стильный интерьер и внимательный персонал делают Mak.by отличным местом для приятного обеда, встречи с друзьями или перекуса на ходу. \n" +
                    "\n" +
                    "Основное меню включает:\n" +
                    "- Сочные бургеры с авторскими соусами.\n" +
                    "- Хрустящую картошку фри.\n" +
                    "- Свежие салаты и закуски.\n" +
                    "- Ароматный кофе и освежающие напитки.\n" +
                    "\n" +
                    "Mak.by — это место, где каждый найдёт что-то на свой вкус!"
        ),
        Restaurant(
            name = "KFC",
            picture = R.drawable.kfc,
            description = "KFC (Kentucky Fried Chicken) — это один из крупнейших мировых брендов быстрого питания, специализирующийся на вкусной и сытной курице, приготовленной по уникальному рецепту с 11 специями. С момента своего основания в 1952 году, KFC стал символом качественного фастфуда, который завоевал любовь миллионов людей по всему миру.\n" +
                    "\n" +
                    "Меню KFC включает:\n" +
                    "- Знаменитые куриные крылышки и грудки, обжаренные до золотистой корочки.\n" +
                    "- Бургеры с курицей, приготовленные с душой и подающиеся с разнообразными соусами.\n" +
                    "- Картошку фри с хрустящей корочкой.\n" +
                    "- Салаты и свежие гарниры.\n" +
                    "- Напитки и десерты для завершения трапезы.\n" +
                    "\n" +
                    "KFC — это место, где ты всегда можешь насладиться сочными и вкусными блюдами с курицей в уютной атмосфере или на вынос."
        ),
    )
}