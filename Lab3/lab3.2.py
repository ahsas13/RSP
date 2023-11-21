import asyncio

pot = 0  # Изначально кастрюля пуста
available = True  # Флаг, указывающий, что кастрюля готова для употребления
currentConsumer = 1  # Текущий дикарь
total_savages = 5  # Общее количество дикарей

# Асинхронная функция для приготовления еды
async def cook():
    print("Повар готовит еду...")
    await asyncio.sleep(2)
    global pot, available
    if pot < 3:
        pot += 1
        print("Повар добавил порцию в кастрюлю")
    available = True
    print(f"В кастрюле {pot} порций")

# Асинхронная функция для еды дикарей
async def consume():
    global pot, available, currentConsumer
    if pot > 0:
        pot -= 1
        print(f"Дикарь {currentConsumer} ест. Осталось в кастрюле: {pot} порций")
    else:
        print(f"Кастрюля пуста. Дикарь {currentConsumer} ждет.")
        available = False
    currentConsumer = (currentConsumer % total_savages) + 1 
    await asyncio.sleep(1)

# Асинхронная функция для симуляции работы дикарей и повара
async def simulation():
    while True:
        if not available:
            await cook()
        await consume()

# Запуск асинхронной симуляции
asyncio.run(simulation())
