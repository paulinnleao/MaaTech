# Frontend React + Vite
FROM node:20-alpine

LABEL authors="Paulo Henrique"

WORKDIR /app

# Copia package.json e yarn.lock
COPY package.json yarn.lock ./

RUN yarn install

# Copia todo o código do frontend
COPY . .

EXPOSE 5173

CMD ["yarn", "dev", "--host"]
