FROM node:22 AS builder

WORKDIR /app

COPY package.json yarn.lock ./
RUN corepack enable
RUN yarn install --frozen-lockfile

COPY . .

RUN yarn run build

FROM nginx:alpine

RUN rm -rf /usr/share/nginx/html/*

COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 5173

CMD ["nginx", "-g", "daemon off;"]