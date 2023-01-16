import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from sklearn.preprocessing import LabelEncoder
from keras.models import load_model
import sys
import joblib
import pickle


#Voy a grabar los archivos en un csv desde java y cargar esos datos aqui de nuevo

def leer_csv():
    # Leer el archivo CSV
    X_test = pd.read_csv("X_test.csv")
    return X_test

def cargar_scaler():
    with open('scaler_r.pkc', 'rb') as file:
        scaler = pickle.load(file)
    return scaler

def cargar_modelo():
    # Cargar el modelo desde el archivo .h5
    model = load_model('modelR.h5')
    return model

def transform_Xtest(X_test, scaler):
    X_test = scaler.transform(X_test)
    return X_test


def predecir(model,X_test):
    # Realizar las predicciones
    predictions = model.predict(X_test)
    return predictions

if __name__ == "__main__":
    print('Predecir')

    X_test = leer_csv()
    scaler = cargar_scaler()
    model = cargar_modelo()
    X_test = transform_Xtest(X_test, scaler)
    predictions = predecir(model,X_test)
    print(predictions)

