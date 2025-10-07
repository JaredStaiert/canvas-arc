import '@mantine/core/styles.css';
//tiptap must be below core
import '@mantine/tiptap/styles.css';

import { AppShell, Burger, Group, MantineProvider, NavLink } from '@mantine/core';
import { theme } from './theme';
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import { useDisclosure } from "@mantine/hooks";
import Dashboard from "@/dashboard/Dashboard";
import { QueryClientProvider } from "@tanstack/react-query";
import { queryClient } from "./queryClient";
import CharListComponent from "@/character/CharListComponent";
import CharWorkbench from "@/character/CharWorkbench";
import EventPage from "@/event/EventPage";
import WorldDashboardPage from "@/world/WorldDashboardPage";
import WorldViewPage from "@/world/WorldViewPage";
import { LandingPage, AuthProvider } from "@/login/AuthProvider";
import AppHeaderMenu from "@/appheader/AppHeaderMenu";

export default function App() {
    const [mobileOpened, { toggle: toggleMobile }] = useDisclosure();
    const [desktopOpened, { toggle: toggleDesktop }] = useDisclosure(false);

    return (
    <MantineProvider theme={theme}>
      <BrowserRouter>
          <QueryClientProvider client={queryClient}>
              <AuthProvider>
                  <LandingPage>
                      <AppShell
                          padding="md"
                          header={{ height: 60 }}
                          navbar={{
                              width: 300,
                              breakpoint: 'sm',
                              collapsed: { mobile: !mobileOpened, desktop: !desktopOpened },
                          }}
                      >
                          <AppShell.Header>
                              <Group h="100%" px="md">
                                  <Burger opened={mobileOpened} onClick={toggleMobile} hiddenFrom="sm" size="sm" />
                                  <Burger opened={desktopOpened} onClick={toggleDesktop} visibleFrom="sm" size="sm" />
                              </Group>
                              <Group
                                  justify="flex-end"
                                  pos="fixed"
                                  top="-0.2rem"
                                  left="3rem"
                              >
                                  <AppHeaderMenu/>
                              </Group>
                          </AppShell.Header>
                          <AppShell.Navbar p="md">
                              <NavLink
                                label="Dashboard"
                                component={Link}
                                to="/"
                              />
                              <NavLink
                                label="Worlds"
                                component={Link}
                                to="/worlds"
                              />
                              <NavLink
                                label="Events"
                                component={Link}
                                to="/events"
                              />
                              <NavLink
                                label="Characters"
                                childrenOffset={28}
                              >
                                  <NavLink
                                      label="All Characters"
                                      component={Link}
                                      to="/characters"
                                  />
                                  <NavLink
                                    label="Active Character"
                                    component={Link}
                                    to="/activecharacter" />
                              </NavLink>
                          </AppShell.Navbar>
                          <AppShell.Main>
                              <Routes>
                                  <Route path="/" element={<Dashboard/>} />
                                  <Route path="/worlds/edit/:worldID" element={<WorldViewPage/>}/>
                                  <Route path="/worlds" element={<WorldDashboardPage/>}/>
                                  <Route path="/events" element={<EventPage/>}/>
                                  <Route path="/characters" element={<CharListComponent/>}/>
                                  <Route path="/activecharacter" element={<CharWorkbench/>}/>
                              </Routes>
                          </AppShell.Main>
                      </AppShell>
                  </LandingPage>
              </AuthProvider>
          </QueryClientProvider>
      </BrowserRouter>
    </MantineProvider>
  );
}