import { JSX } from "react";
import { useQuery } from "@tanstack/react-query";
import { Link } from "react-router-dom";
import { Badge, Box, Button, Grid, Group, Image, Paper, Stack, Text, Title } from "@mantine/core";
import { getWorlds, World } from "@/api/world_api";

function Dashboard() {
  return (
    <>
      <p>This is the dashboard</p>
    </>
  );
}

export default Dashboard;
